pagerduty-alerting-extension
============================

AppDynamics PagerDuty Alerting Extension

Fill out the params.sh file properly where:
    API_KEY is the API key given to a new service in PagerDuty.

Install custom actions using the custom.xml file included in this directory. Follow the following link to learn how to configure custom actions:
    http://docs.appdynamics.com/display/ADPRO/Configure+Custom+Notifications
with everything up to and including "Installing Custom Actions on the Controller"

In summary, you can create policies, health rules, and actions in the AppDynamics UI. Once a specific health rule
is violated, you can configure a custom action to trigger this PagerDuty script. If this script is triggered,
it will create a PagerDuty incident, containing information on which health rule is violated - including details.
Your custom action can also be triggered when a health rule violation has ended. The PagerDuty script will then close
the incident it created. All details can be found in the docs stated above.
