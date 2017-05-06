#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.${artifactId}.backend.service;

import ${package}.${artifactId}.backend.entity.RoleEntity;
import ${package}.${artifactId}.backend.repository.RoleRepository;
import ${package}.${artifactId}.backend.security.AccessControlService;
import ${package}.${artifactId}.model.Role;
import ${package}.${artifactId}.model.service.RoleService;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.modelmapper.spi.MappingContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class DefaultRoleService implements RoleService, MapperService<Role, RoleEntity> {

	@Autowired
	private RoleRepository roleRepository;

	@Autowired
	private AccessControlService accessControlService;

	@Override
	@Transactional(readOnly = true)
	public List<Role> getAll() {
		return roleRepository.findAll().stream().map(role -> convertToModel(role, Role.class))
				.collect(Collectors.toList());
	}

	@Override
	public boolean exists(String roleId) {
		return roleRepository.exists(roleId);
	}

	@Override
	@Transactional(readOnly = true)
	public Role get(String roleId) {
		return convertToModel(roleRepository.getOne(roleId), Role.class);
	}

	@Override
	@Transactional
	public void save(Role role) {
		validate(role);
		roleRepository.save(convertToEntity(role, RoleEntity.class));
		if (accessControlService != null) {
			//accessControlService.clearCache();
		}
	}

	@Override
	public ModelMapper getMapper() {
		ModelMapper mapper = MapperService.super.getMapper();

		mapper.createTypeMap(RoleEntity.class, Role.class).setPostConverter(new Converter<RoleEntity, Role>() {
			@Override
			public Role convert(MappingContext<RoleEntity, Role> context) {
				context.getDestination().setPermissions(context.getSource().getPermissions().stream()
						.map(permission -> new String(permission)).collect(Collectors.toSet()));

				return context.getDestination();
			}
		});

		mapper.createTypeMap(Role.class, RoleEntity.class).setPostConverter(new Converter<Role, RoleEntity>() {
			@Override
			public RoleEntity convert(MappingContext<Role, RoleEntity> context) {
				context.getDestination().setPermissions(context.getSource().getPermissions().stream()
						.map(permission -> new String(permission)).collect(Collectors.toSet()));

				return context.getDestination();
			}
		});

		return mapper;
	}

}
