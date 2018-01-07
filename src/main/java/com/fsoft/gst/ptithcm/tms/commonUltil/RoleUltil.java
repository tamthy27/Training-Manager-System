package com.fsoft.gst.ptithcm.tms.commonUltil;

public enum RoleUltil {
    
	
	DB_SECURITYADMIN("ROLE_db_securityadmin"),
	DB_OWNER("ROLE_db_owner"),
	DB_DATAREADER("ROLE_db_datawriter"),
	DB_DATAWRITER("ROLE_db_datareader"),
	DB_DENYDATAWRITER("ROLE_db_denydatawriter"),
	DB_DENYDATAREADER("ROLE_db_denydatareader"),
	DB_BACKUPOPERATOR("ROLE_db_backupoperator"),
	DB_ACCESSADMIN("ROLE_db_accessadmin");
     
    private String roleUltil;
     
    private RoleUltil(String roleUltil){
        this.roleUltil = roleUltil;
    }
     
    public String getRoleUltil(){
        return this.roleUltil;
    }
     
}
