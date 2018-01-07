package com.fsoft.gst.ptithcm.tms.commonUltil;

/**
 * The Enum RolePermisionUltil.
 * @author NVTT Jun 13, 2017
 */
public enum RolePermisionUltil {
    
	
	/** The a staff. */
	A_STAFF("ROLE_M_A_Staff"),
	
	/** The a trainer. */
	A_TRAINER("ROLE_M_A_Trainer"),
	
	/** The m category. */
	M_CATEGORY("ROLE_M_Category"),
	
	/** The m course. */
	M_COURSE("ROLE_M_Course"),
	
	/** The m topic. */
	M_TOPIC("ROLE_M_Topic"),
	
	/** The p staff. */
	P_STAFF("ROLE_M_P_Staff"),
	
	/** The p trainee. */
	P_TRAINEE("ROLE_M_P_Trainee"),
	
	/** The p trainer. */
	P_TRAINER("ROLE_M_P_Trainer"),
	
	/** The t v topic. */
	T_V_TOPIC("ROLE_Trainer_V_Topic"),
	
	/** The as trainee. */
	AS_TRAINEE("ROLE_AS_Trainee"),
	
	/** The t trainer. */
	AS_TRAINER("ROLE_AS_Trainer"),
    
    /** The s login. */
    S_LOGIN("ROLE_S_Login");
	
	
    /** The role ultil. */
    private String roleUltil;
     
    /**
     * Instantiates a new role permision ultil.
     *
     * @param roleUltil the role ultil
     */
    private RolePermisionUltil(String roleUltil){
        this.roleUltil = roleUltil;
    }
     
    /**
     * Gets the role ultil.
     * @return the role ultil
     */
    public String getRoleUltil(){
        return this.roleUltil;
    }
    
    
}
