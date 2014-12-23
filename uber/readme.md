This folder contains uber interview questions collected

http://www.meetqun.com/thread-3033-1-4.html
-------------------------------------------
Round2: 经典的uber题， design一个excel
Round3: 题目和bitly.com挺像的，做一个long 字符串hash到一个short 字符串，也很简单，说白了就是用两个hashtable，一个key-val是short-long strings， 一个是long-short strings

http://www.meetqun.com/thread-2789-1-15.html
---------------------------------------------
非常简单直接的问题 打印input里面的词+频率， map就行

http://www.meetqun.com/thread-2789-1-15.html
----------------------------------------------
1. 给出一个整数，找出它的比它大的下一个质数
2. median of two sorted array

http://www.meetqun.com/thread-2596-1-5.html
----------------------------------------------
coding: 
input: log file, <user name, login time, logout time>
output: <time,number of users>
假定同一个user的login time, logout time 没有overlap
<"user a", 5,10>
<"user b", 6,8>
<"user c", 10,11>
output:
<5,1> <6,2> <8,1> <10,1> <11,0>

http://www.meetqun.com/thread-2840-1-10.html
--------------------------------------------
我的电面是一道brain teaser。。100个locker一开始都是锁着的，第一次reverse 1， 2， 3， 4。。。； 第二次reverse2， 4， 6， 8。。。。；第三次reverse 3， 6， 9 。。。以此类推，一直到100次，有哪几个是left open. reverse是指open的就关掉，close的就打开(toggle)

http://www.meetqun.com/thread-2520-1-18.html
---------------------------------------------
一道系统设计题，设计一个Service可以输入用户location查询附近的公交站台和所有即将到这些站台的公交车。我随便和他扯了一些系统设计的还有优化算法之类的东西，后来让我写一个控制访问API频率（Ratelimit）的function， 用了一个Queue写完就结束了。
第一个人 ： 让我设计一个 Netflix， follow up 很多 比如如何限制同一个用户多处登录不能同时看一个资源，如何实现根据用户的网速调整清晰度，怎么热门推荐等等。
第二个人 ： 进来直接不闲聊直接让我打开自己电脑开始写一些代码，设计一个 Excel ， 每个cell里面是一个String。 一开始想当然说可以直接用二维矩阵存，后来改成list of lists， 最后改成了HashMap。后续还有evaluate一个string相关的问题（给了黑盒evaluate函数，对每个cell实现evaluate和支持修改）
第三个人 ： 纯聊简历，干聊project，面试官没有准备一道题，到最后我就已经是在找话说了
第四个人 ： 好像是个小领导，先问了问我有没有问题，后来问了一些知识点问题，python有哪些语言特性等等之类的。

http://www.meetqun.com/thread-1913-1-27.html
--------------------------------------------
聊简历 5min。
两道LeetCode原题。
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
request_device				Enum(‘android’, ‘iphone’, ‘sms’, ‘mobile_web’)
status						Enum(‘completed’, ‘cancelled_by_driver’, ‘cancelled_by_client’)
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
role						Enum(‘client’, ‘driver’, ‘partner’)
creationtime				timestamp with time zone
```
1. For request times between 12/1/2013 10:00:00 PST & 12/8/2013 17:00:00 PST, how many completed trips (Hint: look at the trips.status column) were requested on iphones in City #5? on android phones?
2. In City #8, how many unique, currently unbanned clients requested a trip in October 2013 that was eventually completed? Of these, how many trips did each client take?
3. In City #8, how many unique, currently unbanned clients requested a trip between 9/10/2013 and 9/20/2013, with drivers who started between 9/1/2013 and 9/10/2013 and are currently banned, that was eventually completed?

http://www.meetqun.com/thread-1047-1-23.html
--------------------------------------------
We would like build a location search service that predicts where a client should be picked up and and dropped off. This feature will be used as a means of providing suggested pickup and dropoff locations when a user opens the Uber app.
This service will have access to a client’s trip history (below you’ll find a week’s worth of trip data for a frequent Uber rider). The only signals you’ll have are the user’s request location location and the current date time. Please build a service using Python and Flask that does the following:

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
When you’re done, host it somewhere and provide us with a URL and a tarball or Git repo with the code.
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