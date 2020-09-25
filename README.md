# Multi-Region
What is multi-Region and DR setup

Benefits of Multi-Region
	
	High Availability
	Faster Response time
	Geolocation laws

Pitfalls of Multi-Region
	
	Complexity
	Effort
	Costing

Various patterns
	
	Backup and Store
	Pilot Light
	Warm Standby
	Active-2
	
DR setup
	
	Create a global dynamo DB table using Terraform Script
	
	Create an IAM user who have access to this table
	
	Test manually by inserting and deleting the data in the table
	
	It should be replicating in the different regions
	
	Create a spring boot service which will connect to this DB
	
	Test this service locally by connoting to any regional end points
	
	Have separate property files to make your application region aware for regional end points
	
	Create two ec2 machines in two different Regions where you AWS Dynamo DB tables are
	
	Install the latest java version
	
	Upload the jar file to both these machines
	
	Run the jar with specific regional property file
	
	Make sure you have an inbound traffic added to the security group for both of your ec2 machines
	
	Register a domain on Route53
	
	Setup a health check  for your primary region service
	
	Configure this domain to point to the service in DR mode
	
	Make one region as primary and other secondary
	
	Make the required GET and POST calls to your domain and make sure operations are working
	
	You can confirm with 'aws:rep:updateregion' column that all the newly created records are from your primary region.
	
	Remove the inbound traffic on port 8080 from your primary region to simulate the failover
	
	Once health check is failing for your primary region, make the GET and POST calls again to your domain
	
	It should be working with secondary region. You can confirm that with the newly created record in the secondary region.
	
	
	

	
