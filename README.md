# AppDynamics PagerDuty - Alerting Extension

##Use Case

PagerDuty provides SaaS IT on-call schedule management, alerting and incident tracking. AppDynamics integrates directly with PagerDuty to create incidents in response to alerts. With the PagerDuty integration you can leverage your existing alerting infrastructure to notify the operations team to resolve performance degradation.

### Prerequisites

- You should have a PagerDuty Service Key

##Installation Steps

 1. Run "mvn clean install -DskipTests". You can run the tests by configuring the service key in the config.yaml file in the test resources folder.

 2. Find the zip file at 'target/pagerduty-alert.zip' or Download the PagerDuty Alerting Extension zip from [AppDynamics Exchange](http://community.appdynamics.com/t5/AppDynamics-eXchange/idb-p/extensions)

 3. Unzip the pagerduty-alert.zip file into <CONTROLLER_HOME_DIR>/custom/actions/ . You should have  <CONTROLLER_HOME_DIR>/custom/actions/pagerduty-alert created.

 4. Check if you have custom.xml file in <CONTROLLER_HOME_DIR>/custom/actions/ directory. If yes, add the following xml to the <custom-actions> element.
 
   ```
      <action>
    		  <type>pagerduty-alert</type>
          <!-- For Linux/Unix *.sh -->
     		  <executable>pagerduty-alert.sh</executable>
          <!-- For windows *.bat -->
     		  <!--<executable>pagerduty-alert.bat</executable>-->
      </action>
  ```
     
   If you don't have custom.xml already, create one with the below xml content
    
      ```
      <custom-actions>
          <action>
      		  <type>pagerduty-alert</type>
            <!-- For Linux/Unix *.sh -->
       		  <executable>pagerduty-alert.sh</executable>
            <!-- For windows *.bat -->
       		  <!--<executable>pagerduty-alert.bat</executable>-->
     	    </action>
        </custom-actions>
      ```
      Uncomment the appropriate executable tag based on windows or linux/unix machine.
    
    5. Update the config.yaml file in <CONTROLLER_HOME_DIR>/custom/actions/pagerduty-alert/conf/ directory with the Service Key. You can also configure the level of details sent to PagerDuty.

###Note
Please make sure to not use tab (\t) while editing yaml files. You may want to validate the yaml file using a yaml validator http://yamllint.com/

    	
```	
	#PagerDuty Service Key
	serviceKey: ""
		
	#scheme used (http/https)
	protocol: "https"
	
	#PagerDuty host
	host: "events.pagerduty.com"
	
	#PagerDuty url path
	urlPath: "/generic/2010-04-15/create_event.json"
	
	#http timeouts
	connectTimeout: 10000
	socketTimeout: 10000
	
	#show appdynamics details in pagerduty alert
	showDetails: true      
```        
         

    Below is how the AppDynamics event's parameters are associated with PagerDuty parameters:

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

2. Installing Custom Actions:

     To create a Custom Action, first refer to the the following topics (requires login):
     * [Creating custom action](http://docs.appdynamics.com/display/PRO14S/Custom+Actions)
     * [Build an Alerting Extension](http://docs.appdynamics.com/display/PRO14S/Build+an+Alerting+Extension)

Now you are ready to use this extension as a custom action. In the AppDynamics UI, go to Alert & Respond -> Actions. Click Create Action. Select Custom Action and click OK. In the drop-down menu you can find the action called 'pagerduty-alert'.

3. Look for the newest created Incident in PagerDuty.


   Once an incident is filed it will have the following list view:

![](http://appsphere.appdynamics.com/t5/image/serverpage/image-id/83i64EA0DAEED76521B/image-size/original?v=mpbl-1&px=-1)

   When the **Details** button of this is clicked it will link to a similar page:

![](http://appsphere.appdynamics.com/t5/image/serverpage/image-id/85iDCB38EF96412EB25/image-size/original?v=mpbl-1&px=-1)

   And finally to view the event of the incident in JSON it will look similar to the following:

![](http://appsphere.appdynamics.com/t5/image/serverpage/image-id/87i53C89765515BD9EF/image-size/original?v=mpbl-1&px=-1)


##Contributing

Find out more in the [AppDynamics Exchange](http://community.appdynamics.com/t5/AppDynamics-eXchange/idb-p/extensions)

##Support

For any questions or feature request, please contact [AppDynamics Center of Excellence](mailto:ace-request@appdynamics.com).

**Version:** 1.1
**Controller Compatibility:** 3.7+
