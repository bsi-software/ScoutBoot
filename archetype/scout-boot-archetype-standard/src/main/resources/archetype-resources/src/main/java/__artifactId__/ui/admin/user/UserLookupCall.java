#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.${artifactId}.ui.admin.user;

import ${package}.${artifactId}.model.User;
import ${package}.${artifactId}.model.service.UserService;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import org.eclipse.scout.rt.shared.services.lookup.ILookupRow;
import org.eclipse.scout.rt.shared.services.lookup.LocalLookupCall;
import org.eclipse.scout.rt.shared.services.lookup.LookupRow;

public class UserLookupCall extends LocalLookupCall<String> {

  @Inject
  UserService userService;

  private static final long serialVersionUID = 1L;

  @Override
  protected List<? extends ILookupRow<String>> execCreateLookupRows() {
    List<ILookupRow<String>> list = new ArrayList<>();

    for (User user : userService.getAll()) {
      list.add(new LookupRow<>(user.getId(), user.toDisplayText()));
    }

    return list;
  }
}
