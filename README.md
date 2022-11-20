# IgnitionAuto
Vehicle Management Project - Java , MySQL , JDBC, JAVA MAIL SMTP


###
Simple software where you can log into your account or create one by confirming by entering the code you received on your email.
Also, when you register or log into your account,  you choose a role .(Admin, Client).Each role has a menu ,If you forgot your password you can reset it by entering the verification code sent to your email.

-Passwords are hashing with Sha256
-Our program have validations(regex for email,username,password and etc...) 

-email sent during registration looks like this,there is one code,which we are entering in the console,to confirm our registration.

<img width="900" height="300" alt="image" src="https://user-images.githubusercontent.com/49691399/202919101-e406558b-1f4a-4e4f-9660-1f6e7fdb4518.png">
***

As I said, each role has a corresponding menu,roles are Admin,Client.Lets see the menus and see what they do.
<h1>CLIENT ROLE</h1>

<img width="421" alt="Screenshot 2022-11-20 at 20 35 46" src="https://user-images.githubusercontent.com/49691399/202919985-dc4adddb-cd35-4a82-96ad-d749475dc42e.png">
1) will display all cars from the database,we can select how to display by type, name, price(we can make our price preferences, like show vehicles from min price to max price) 
2)search vehicle
3)Candidate for a position in the Vehicle Company(Ignition Auto) 
-positions are (manager,auto mechanic,tire technician and others..)
-each position has application requirements:if you want to candidate as a <b>manager</b> you need to have high education and experience at this position at least 4 years

#### Lets test for position,that we are not compatible.

<img width="399" alt="image" src="https://user-images.githubusercontent.com/49691399/202921098-5defc307-583f-46e0-b513-14fd260e0df6.png">


#### if everything is ok,we will see this:

<img width="486" alt="image" src="https://user-images.githubusercontent.com/49691399/202921165-a2f9a90c-aa9a-4501-b92c-fa2ed01b8514.png">

-also we will be registered to the <b> employee <b> database <img width="599" alt="image" src="https://user-images.githubusercontent.com/49691399/202921276-d6a6bdee-38f2-41f6-989f-f4de00357fb7.png">

***** other choices from the menu ,are not working yet (but soon will work) 
  
  
