package com.broccoli.basis.hibernate;

import org.hibernate.AssertionFailure;
import org.hibernate.cfg.ImprovedNamingStrategy;
import org.hibernate.internal.util.StringHelper;

public class BasisImprovedNamingStrategy extends ImprovedNamingStrategy {

	private static final long serialVersionUID = -6192458068043953578L;

	@Override
	public String foreignKeyColumnName(
			String propertyName, String propertyEntityName, String propertyTableName, String referencedColumnName
	) {
		String header = propertyName != null ? StringHelper.unqualify( propertyName ) : propertyTableName;
		if ( header == null ) throw new AssertionFailure( "NamingStrategy not properly filled" );
		return columnName( header + "_" + referencedColumnName );
	}
	
	@Override
	public String tableName(String tableName) {
		return "T_" + addUnderscores(tableName);
	}
}
