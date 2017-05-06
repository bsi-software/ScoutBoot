#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.${artifactId}.backend.controller;

import ${package}.${artifactId}.ServletConfiguration;
import ${package}.${artifactId}.model.Task;
import ${package}.${artifactId}.model.service.TaskService;

import java.security.Principal;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.SpringVersion;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * REST controller to provide permissioned read access to tasks. 
 * Important: Renaming permission classes/packages needs to be reflected here.
 */
@RestController
@RequestMapping(ServletConfiguration.API_CONTEXT_PATH + "/tasks")
public class TaskController {

	public static final String READ_TASKS = "${package}.${artifactId}.ui.business.task.ReadTaskPermission";
	public static final String READ_ALL_TASKS = "${package}.${artifactId}.ui.business.task.ViewAllTasksPermission";

	public static final String AUTH_OWN = "hasAuthority('" + READ_TASKS + "')";
	public static final String AUTH_ALL = AUTH_OWN + " and hasAuthority('" + READ_ALL_TASKS + "')"; 

	@Autowired
	private TaskService taskService;

	@RequestMapping(path = {"", "/", "/info"})
	public Map<String, String> info() {
		final Map<String, String> info = new HashMap<>();
		info.put("api", "Task API");
		info.put("version", "Spring " + SpringVersion.getVersion());
		return info;
	}

	@RequestMapping("/{id}")
	@PreAuthorize(AUTH_OWN)
	public Task showTaskById(@PathVariable String id) {
		return taskService.get(UUID.fromString(id));
	}

	@RequestMapping("/inbox")
	@PreAuthorize(AUTH_OWN)
	public Collection<Task> inbox(Principal principal) {
		return taskService.getInbox(principal.getName());
	}

	@RequestMapping("/today")
	@PreAuthorize(AUTH_OWN)
	public Collection<Task> today(Principal principal) {
		return taskService.getToday(principal.getName());
	}

	@RequestMapping("/own")
	@PreAuthorize(AUTH_OWN)
	public Collection<Task> own(Principal principal) {
		return taskService.getOwn(principal.getName());
	}

	@RequestMapping("/all")
	@PreAuthorize(AUTH_ALL)
	public Collection<Task> all() {
		return taskService.getAll();
	}

}
