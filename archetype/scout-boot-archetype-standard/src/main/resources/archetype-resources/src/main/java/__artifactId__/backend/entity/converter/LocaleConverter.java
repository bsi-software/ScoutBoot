#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.${artifactId}.backend.entity.converter;

import java.util.Locale;

import javax.persistence.AttributeConverter;

public class LocaleConverter implements AttributeConverter<Locale, String> {

  @Override
  public String convertToDatabaseColumn(Locale locale) {
    if (locale == null) {
      return null;
    }

    return locale.toLanguageTag();
  }

  @Override
  public Locale convertToEntityAttribute(String locale) {
    if (locale == null) {
      return null;
    }

    return Locale.forLanguageTag(locale);
  }

}
