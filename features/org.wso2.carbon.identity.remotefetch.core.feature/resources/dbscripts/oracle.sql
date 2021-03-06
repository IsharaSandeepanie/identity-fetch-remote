CREATE TABLE IDN_REMOTE_FETCH_CONFIG(
	ID INTEGER NOT NULL AUTO_INCREMENT,
	TENANT_ID INTEGER NOT NULL,
	IS_ENABLED CHAR(1) NOT NULL,
	USER_NAME  VARCHAR2(255) NOT NULL,
	REPO_MANAGER_TYPE VARCHAR2(255) NOT NULL,
	ACTION_LISTENER_TYPE VARCHAR2(255) NOT NULL,
	CONFIG_DEPLOYER_TYPE VARCHAR2(255) NOT NULL,
	ATTRIBUTES_JSON CLOB NOT NULL,
	CONSTRAINT PK_IDN_REMOTE_FETCH_CONFIG PRIMARY KEY (ID),
	CONSTRAINT UC_CONFIG UNIQUE (REPO_MANAGER_TYPE, CONFIG_DEPLOYER_TYPE, TENANT_ID)    
);

CREATE TABLE IDN_REMOTE_FETCH_REVISIONS(
	ID INTEGER NOT NULL AUTO_INCREMENT,
	CONFIG_ID INTEGER NOT NULL,
	FILE_PATH VARCHAR2(255) NOT NULL,
	FILE_HASH VARCHAR2(255),
	DEPLOYED_DATE DATE,
	DEPLOYMENT_STATUS VARCHAR2(255),
	ITEM_NAME VARCHAR2(255),
	CONSTRAINT PK_IDN_REMOTE_FETCH_REVISIONS PRIMARY KEY (ID),
	FOREIGN KEY (CONFIG_ID) REFERENCES IDN_REMOTE_FETCH_CONFIG (ID) ON DELETE CASCADE,
	CONSTRAINT UC_REVISIONS UNIQUE (CONFIG_ID, ITEM_NAME)
);

