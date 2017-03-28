#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.${artifactId}.hello;

import org.eclipse.scout.rt.client.ui.form.AbstractForm;
import org.eclipse.scout.rt.client.ui.form.fields.groupbox.AbstractGroupBox;
import org.eclipse.scout.rt.client.ui.form.fields.stringfield.AbstractStringField;

public class HelloForm extends AbstractForm {

	public class MainBox extends AbstractGroupBox {

		public class HelloBox extends AbstractGroupBox {

			public class HelloField extends AbstractStringField {

				@Override
				protected void execInitField() {
					setLabel("Hello");
					setValue("World");
				}
			}
		}
	}
}