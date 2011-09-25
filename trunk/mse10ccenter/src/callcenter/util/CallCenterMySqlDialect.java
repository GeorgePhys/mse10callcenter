package callcenter.util;

public class CallCenterMySqlDialect extends org.hibernate.dialect.MySQLDialect {

    @Override
    public String getTableTypeString() {
	// ?useUnicode=true&amp;amp;characterEncoding=UTF-8
	return " DEFAULT CHARSET=utf8 COLLATE utf8_general_ci";
    }
}
