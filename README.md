# AppDynamics PagerDuty Extension

##Use Case

PagerDuty provides SaaS IT on-call 
schedule management, alerting and incident tracking.
AppDynamics integrates directly with PagerDuty to create incidents in response to alerts. With the PagerDuty integration you can leverage your existing alerting infrastructure to notify the operations team to resolve performance degradation.

##Installation

1. Modify the IntegrationsSDK/CustomNotification/alarming/createPagerDutyAlarm/params.sh  file as follows:

  a. Modify the API_KEY variable to be a the API key that is generated through PagerDuty when a new service is created in your specific environment

  b. Notice that in the createPagerDutyAlarm.sh file that the AppDynamics parameters have been formatted into a custom JSON object to be viewed later in the designated PagerDuty service.

    The createPagerDutyAlarm.sh file follows the following table to tie in the parameters together:

	<table>
	<tr>
	<td>AppDynamics Parameters</td>
	<td>PagerDuty Parameters</td>
	<td>Comments</td>
	</tr>
		
	
	<tr>
	<td></td>
	<td>service_key</td>
	<td>This field is meant for the API key that is generated when a new service
	is created in a PagerDuty environment.
	</tr>
		 
	
	<tr>
	<td></td>
	<td>event_type</td>
	<td>This field is used for all types of integration APIs available in
	PagerDuty. For this specific task we require that this parameter be set
	as "trigger".</td>
	</tr>
	
	<tr>
	<td> 
	<table>

	<tr>
	<td>APP_NAME</td>
	</tr>

	<tr>
	<td>  
	 PVN_ALERT_TIME</td>
	</tr>

	<tr>
	<td>  
	 SEVERITY</td>
	</tr>

	<tr>
	<td>  
	 POLICY_NAME</td>
	</tr>

	<tr>
	<td>  
	 AFFECTED_ENTITY_TYPE</td>
	</tr>

	<tr>
	<td>  
	 AFFECTED_ENTITY_NAME</td>
	</tr>

	<tr>
	<td>  
	 EVALUATION_TYPE</td>
	</tr>

	<tr>
	<td>  
	 EVALUATION_ENTITY_NAME</td>
	</tr>

	<tr>
	<td>  
	 SCOPE_TYPE_x</td>
	</tr>

	<tr>
	<td>  
	 SCOPE_NAME_x</td>
	</tr>

	<tr>
	<td>  
	 CONDITION_NAME_x</td>
	</tr>

	<tr>
	<td>  
	 THRESHOLD_VALUE_x</td>
	</tr>

	<tr>
	<td>  
	 OPERATOR_x</td>
	</tr>

	<tr>
	<td>  
	 BASELINE_NAME_x</td>
	</tr>

	<tr>
	<td>  
	 USE_DEFAULT_BASELINE_x</td>
	</tr>

	<tr>
	<td>  
	 OBSERVED_VALUE_x</td>
	</tr>

	<tr>
	<td>  
	 DEEP_LINK_URL</td>
	</table>
	</td>
		
	<td>details</td>
		
	<td>Since there are certain limitations in the PagerDuty API in terms of the
	format of details that can be shown, this whole field is created as its
	own JSON object.  
	 The format is as follows for the following Policy Violation Parameters:
	<table>

	<tr>
	<td><strong>Variable name: Variable value</strong></td>
	</tr>

	<tr>
	<td>Application Name: APP_NAME</td>
	</tr>

	<tr>
	<td>Policy 	Violation Alert Time: PVN_ALERT_TIME</td>
	</tr>

	<tr>
	<td>Severity: SEVERITY</td>
	</tr>

	<tr>
	<td>Name of Violated Policy: POLICY_NAME</td>
	</tr>

	<tr>
	<td>Affected Entity Type: AFFECTED_ENTITY_TYPE</td>
	</tr>

	<tr>
	<td>Name of Affected Entity: AFFECTED_ENTITY_NAME</td>
        </tr>

        <tr>
	<td>Evaluation Entity #x</td>
	</tr>

	<tr>
	<td>Evaluation Entity: EVALUATION_TYPE</td>
	</tr>

	<tr>
	<td>Evaluation Entity Name: EVALUATION_ENTITY_NAME</td>
	</tr>

	<tr>
	<td>Triggered Condition #x</td>
	</tr>

	<tr>
	<td>Scope Type:	SCOPE_TYPE_x</td>
	</tr>

	<tr>
	<td>Scope Name: SCOPE_NAME_x</td>
	</tr>

	<tr>
	<td>CONDITION_NAME_x OPERATOR_x THRESHOLD_VALUE_x (this is for
	    ABSOLUTE conditions)</td>
	</tr>

	<tr>
	<td>Violation Value: OBSERVED_VALUE_x</td>
	</tr>

	<tr>
	<td>DEEP_LINK_URL
	</td>
	</tr>
	</table>  
	</td>
	</tr>
	
	<tr>
	<td>POLICY_NAME</td>
	<td>description</td>
	<td>This is the short description area that will be shown in the list view
	of PagerDuty incidents.</td>
	</tr>

	</table>

2. Install Custom Actions

   To create a Custom Action using PagerDuty, first refer to the "Installing Custom Actions into the Controller" topic [here](http://docs.appdynamics.com/display/PRO12S/Configure+Custom+Notifications#ConfigureCustomNotifications-InstallingCustomActionsontheController) (requires login).

   The custom.xml file and createPagerDutyAlarm directory used for this custom notification are located within the IntegrationsSDK/CustomNotification/alarming/ directory.

   Place the createPagerDutyAlarm directory (containing params.sh and createPagerDutyAlarm.sh) along with the custom.xml file into the <controller_install_dir>/custom/actions/ directory.

3. Look for the newest created Incident in PagerDuty.


   Once an incident is filed it will have the following list view:

![](http://appsphere.appdynamics.com/t5/image/serverpage/image-id/83i64EA0DAEED76521B/image-size/original?v=mpbl-1&px=-1)

   When the **Details** button of this is clicked it will link to a similar page:

![](http://appsphere.appdynamics.com/t5/image/serverpage/image-id/85iDCB38EF96412EB25/image-size/original?v=mpbl-1&px=-1)

   And finally to view the event of the incident in JSON it will look similar to the following:

![](http://appsphere.appdynamics.com/t5/image/serverpage/image-id/87i53C89765515BD9EF/image-size/original?v=mpbl-1&px=-1)


##Contributing


Always feel free to fork and contribute any changes directly via GitHub.


##Support

For any support questions, please contact ace@appdynamics.com.




