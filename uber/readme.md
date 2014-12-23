This folder contains uber interview questions collected

http://www.meetqun.com/thread-3033-1-4.html
-------------------------------------------
Round2: �����uber�⣬ designһ��excel
Round3: ��Ŀ��bitly.comͦ��ģ���һ��long �ַ���hash��һ��short �ַ�����Ҳ�ܼ򵥣�˵���˾���������hashtable��һ��key-val��short-long strings�� һ����long-short strings

http://www.meetqun.com/thread-2789-1-15.html
---------------------------------------------
�ǳ���ֱ�ӵ����� ��ӡinput����Ĵ�+Ƶ�ʣ� map����

http://www.meetqun.com/thread-2789-1-15.html
----------------------------------------------
1. ����һ���������ҳ����ı��������һ������
2. median of two sorted array

http://www.meetqun.com/thread-2596-1-5.html
----------------------------------------------
coding: 
input: log file, <user name, login time, logout time>
output: <time,number of users>
�ٶ�ͬһ��user��login time, logout time û��overlap
<"user a", 5,10>
<"user b", 6,8>
<"user c", 10,11>
output:
<5,1> <6,2> <8,1> <10,1> <11,0>

http://www.meetqun.com/thread-2840-1-10.html
--------------------------------------------
�ҵĵ�����һ��brain teaser����100��lockerһ��ʼ�������ŵģ���һ��reverse 1�� 2�� 3�� 4�������� �ڶ���reverse2�� 4�� 6�� 8����������������reverse 3�� 6�� 9 �������Դ����ƣ�һֱ��100�Σ����ļ�����left open. reverse��ָopen�ľ͹ص���close�ľʹ�(toggle)

http://www.meetqun.com/thread-2520-1-18.html
---------------------------------------------
һ��ϵͳ����⣬���һ��Service���������û�location��ѯ�����Ĺ���վ̨�����м�������Щվ̨�Ĺ�������������������һЩϵͳ��ƵĻ����Ż��㷨֮��Ķ�������������дһ�����Ʒ���APIƵ�ʣ�Ratelimit����function�� ����һ��Queueд��ͽ����ˡ�
��һ���� �� �������һ�� Netflix�� follow up �ܶ� �����������ͬһ���û��ദ��¼����ͬʱ��һ����Դ�����ʵ�ָ����û������ٵ��������ȣ���ô�����Ƽ��ȵȡ�
�ڶ����� �� ����ֱ�Ӳ�����ֱ�����Ҵ��Լ����Կ�ʼдһЩ���룬���һ�� Excel �� ÿ��cell������һ��String�� һ��ʼ�뵱Ȼ˵����ֱ���ö�ά����棬�����ĳ�list of lists�� ���ĳ���HashMap����������evaluateһ��string��ص����⣨���˺ں�evaluate��������ÿ��cellʵ��evaluate��֧���޸ģ�
�������� �� ���ļ���������project�����Թ�û��׼��һ���⣬������Ҿ��Ѿ������һ�˵��
���ĸ��� �� �����Ǹ�С�쵼��������������û�����⣬��������һЩ֪ʶ�����⣬python����Щ�������Եȵ�֮��ġ�

http://www.meetqun.com/thread-1913-1-27.html
--------------------------------------------
�ļ��� 5min��
����LeetCodeԭ�⡣
1. Best Time to Buy and Sell Stock 
2. Binary Tree Level Order Traversal

http://www.meetqun.com/thread-2077-1-34.html                      
SQL TEST:
Assume a PostgreSQL database, server timezone is UTC. 
```
Table Name: trips.
Column Name					Datatype:
id							integer
client_id					integer (Foreign keyed to users.usersid)
driver_id					integer (Foreign keyed to users.usersid)
city_id						integer
client_rating				integer
driver_rating				integer
request_device				Enum(��android��, ��iphone��, ��sms��, ��mobile_web��)
status						Enum(��completed��, ��cancelled_by_driver��, ��cancelled_by_client��)
predicted_eta				integer
actual_eta					integer
request_at					timestamp with timezone
```
```
Table Name: users
Column Name:				Datatype:
usersid						integer
email						character varying
firstname					character varying
lastname					character varying
banned						Boolean
role						Enum(��client��, ��driver��, ��partner��)
creationtime				timestamp with time zone
```
1. For request times between 12/1/2013 10:00:00 PST & 12/8/2013 17:00:00 PST, how many completed trips (Hint: look at the trips.status column) were requested on iphones in City #5? on android phones?
2. In City #8, how many unique, currently unbanned clients requested a trip in October 2013 that was eventually completed? Of these, how many trips did each client take?
3. In City #8, how many unique, currently unbanned clients requested a trip between 9/10/2013 and 9/20/2013, with drivers who started between 9/1/2013 and 9/10/2013 and are currently banned, that was eventually completed?

http://www.meetqun.com/thread-1047-1-23.html
--------------------------------------------
We would like build a location search service that predicts where a client should be picked up and and dropped off. This feature will be used as a means of providing suggested pickup and dropoff locations when a user opens the Uber app.
This service will have access to a client��s trip history (below you��ll find a week��s worth of trip data for a frequent Uber rider). The only signals you��ll have are the user��s request location location and the current date time. Please build a service using Python and Flask that does the following:

This service should support queries to this endpoint: /predict?request_lat=XXX&request_lng=YYY
The response should should appear as:
```
{
    pickup_suggestions: [
        {lat: xxx, lng: yyy},
        {lat: xxx, lng: yyy},
        {lat: xxx, lng: yyy}],
    dropoff_suggestions: [
        {lat: xxx, lng: yyy},
        {lat: xxx, lng: yyy},
        {lat: xxx, lng: yyy}],
}
```
Approximate Time to Spend: 2 - 3 hours.
Please provide a detailed written response to the following questions:
1. What type of data pipeline would you set up to have this in production? Would this be an offline or online model? Should this be a real time service?
2. If the amount of data generated increases by 10x every month, what architectural changes will this service need.
3. What other features would you add if you had more time?
4. What other kind of data would you collect to make this feature more awesome? How feasible is it to collect this kind of data?
```
SAMPLE TRIP DATA - COMMA DELIMITED
user_id,pickup_lat,pickup_lng,dropoff_lat,dropoff_lng,date
1,37.776416793,-122.423856811,37.7615133871,-122.423856811,2014-07-14 09:28:31
1,37.7616990573,-122.42571153,37.7612015169,-122.42571153,2014-07-14 19:34:24
1,37.7611402196,-122.412709001,37.7763094617,-122.412709001,2014-07-14 20:42:19
1,37.7767692789,-122.42409949,37.7616008576,-122.42409949,2014-07-15 09:19:34
1,37.7618945669,-122.425924762,37.7766056689,-122.425924762,2014-07-15 18:57:21
1,37.7764699018,-122.424185969,37.7880167943,-122.424185969,2014-07-19 19:07:17
```

http://baozitraining.org/blog/2014-star-startup-interview-uber/
-----------------------------------------------------------------
Coding + OO design (Design windows excel)
In excel, one cell can refer to other cells, if I update one cell, how do you update all the dependent cells

http://www.glassdoor.com/Interview/No-difficult-question-All-the-questions-were-open-ended-like-how-would-you-design-netflix-online-spreadsheet-tell-me-about-QTN_778648.htm
-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------
how would you design netflix,online spreadsheet

http://www.glassdoor.com/Interview/Given-a-regular-expression-pattern-and-a-string-check-to-see-if-pattern-matches-the-string-QTN_726967.htm
--------------------------------------------------------------------------------------------------------------------------------------------
Implement LRU cache with get and set operations in constant time O(1).
Given a regular expression pattern and a string, check to see if pattern matches the string.

http://www.glassdoor.com/Interview/Design-a-distributed-system-for-sorting-of-large-files-QTN_789026.htm
---------------------------------------------------------------------------------------------------------
Design a distributed system for sorting of large files

http://www.glassdoor.com/Interview/My-coding-challenge-had-to-calculate-the-nearest-transit-stop-given-your-current-location-They-asked-for-an-efficient-way-QTN_616052.htm
----------------------------------------------------------------------------------------------------------------------------------------------------------------------------
My coding challenge had to calculate the nearest transit stop given your current location. They asked for an efficient way to do this. The answer ended up being something I was not familiar with, Mongo DB and such database geo location built in functions.  

http://www.glassdoor.com/Interview/Please-find-our-standard-web-test-below-Code-Test-Bam-Uber-clients-are-able-to-store-favorite-locations-for-easy-QTN_455264.htm
----------------------------------------------------------------------------------------------------------------------------------------------------------------------------
(6-8 hours code test)
Code Test! Bam!
Uber clients are able to store favorite locations for easy pickup requests. Create a backend and a frontend for managing favorite locations.
This is a simple exercise, but organize, design and test your code as if it were going into production.
When you��re done, host it somewhere and provide us with a URL and a tarball or Git repo with the code.
Backend
Using the language (Python preferred), libraries and data store of your choosing, create a JSON in/out RESTful API for managing favorite locations. Stay away from Django or Rails, but microframeworks like Flask (preferred), Sinatra or Express are fine.
Attributes of a favorite location object include: id, lat, lng, address (e.g. 800 Market Street, San Francisco, CA 94114), name (e.g. Work)
Frontend
Using JavaScript, Backbone.js and any other libraries of your choosing, create an interface to access the API. User should be able to:
Create a new location
Read/view a location, and a collection of all locations
Update an existing location
Delete a location
The UX is up to you, with a couple of constraints:
Incorporate a map
Geocode the address so the user is not required to enter lat/lng
Extras
If you like, get creative and do whatever else you like on the backend and/or frontend to show off.  