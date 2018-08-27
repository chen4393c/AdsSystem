# AdsSystem
A simple web service for ads system built with Java Servlet and MySQL

<ul>
  <li>Built an HTTP web service for users to search events and purchase tickets with AJAX.</li>
  <li>Designed RESTful APIs with Java Servlet to handle users' requests for adding an ad/advertiser.</li>
  <li>Built MySQL database to record add and advertiser info.</li>
  <li>Increased the extensibility by introducing Factory Pattern to integrate MongoDB implementations in the near future.</li>
  <li>Designed the ad rank computation algorithm to compute ad rank and get the ad with highest rank score.</li>
</ul>

## Getting Started

These instructions will get you a copy of the project up and running on your local machine for development and testing purposes. 
See deployment for notes on how to deploy the project on a live system.

### Prerequisites
<li>JDK 1.8+</li>
<li>Apache Tomcat server</li>
<li>MySQL, active JDBC</li>
<li>Java API for JSON</li>

### Installing

A step by step series of examples that tell you how to get a development env running

1. Create a new workspace on your new computer

2. Install and configure Apache Tomcat server with your IDE (Eclipse Java EE or Intellij IDEA Ultimate version)

4. Copy your existing project Jupiter under you new workspace/project directory 
  
5. <b>In Eclipse</b>, click File -> Open Projects from File System. Click "show other specialized import wizards", and select "Existing Projects into Workspace" under General folder. Select Jupiter folder as root directory and click finish. <b>In Intellij</b>, select "Import Project" and select the Jupiter folder.

6. Launch the server.

7. Test the website with the following URL: 

    For Eclipse: http://localhost:8080/AdsSystem
    
    For Intellij IDEA: http://localhost:8080/
    
## Running the tests

Create a new advertiser:
```
url: http://localhost:8080/AdsSystem/CreateAdvertiser
method: POST
body: 
{
  'name':"att",
  'budget' : 200
}
```
Create a new ad:
```
url: http://localhost:8080/AdsSystem/CreateAd
method: POST
body:
{
  'bid':2.0,
  'image_url' : "https://boygeniusreport.files.wordpress.com/2016/10/google-pixel-xl.jpg?quality=98&strip=all&w=782", 
  'advertiser_id': 1, 
  'ad_score': 0.5
}
```
Update budget for an advertiser:
```
url: http://localhost:8080/AdsSystem/UpdateBudget
method: POST
body:
{
  "advertiser_id": 1,
  "budget": 400
}
```
Update bid for an ad:
```
url: http://localhost:8080/AdsSystem/UpdateBid
method: POST
body:
{
  "ad_id": 1,
  "bid": 2.5
}
```
Compute ad rank and get the ad with highest rank score:
```
url: http://localhost:8080/AdsSystem/Ad
method: GET
```

## Authors

* **Chaoran Chen** - *Initial work* - [ChaoranChen](https://github.com/chen4393c)

## Acknowledgments

* Mia
* Vincent Chen
* Henry
