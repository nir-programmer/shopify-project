


# Shopify 

## Overview
   Shopify is a complete Java Spring Boot Web application for an online e-shop.\
   The app is used by employees and customers.\
   The app itself contains two maven modules each of which is a separate Spring Boot application.\
   The application is called ShopifyBackEnd it is used by the employees with their various Roles. 
   The second application is called ShopifyFronteEnd and it is used by the customers.\


<!---ADD LINK TO ROLES-->



## ShopifyBackEnd Application - Main Features
<!-- <details open="open">
	<ul>
		<li><a href="#authentication-and-authorization">Authentication and Authorization</a></li>
      <li><a href="#manage-employees-and-customers-accounts">Manage Employees and Customers Accounts</a></li>
		<li>
			<ul>
				<li>
					<a href="#accessing-data-in-h2-database">Accessing Data in H2 Database</a>
					<ul>
						<li><a href="#h2-console">H2 Console</a></li>
					</ul>
				</li>
			</ul>
		</li>
		<li><a href="#running-the-application-via-docker-container">Running the application via docker container</a></li>
	</ul>
</details> -->


- Authentication and Authorization.
- Manage Employees and Customers Accounts
- Manage Products.
- Manage Brands.
- Manage Categories.
- Manage Brands.
- Manage settings.
- Manage Orders.

### The following video demonstrates a number of product management related actions that an employee of a company with the role of admin can perform when using the site:

1. login
2. Show all products (including sorting, searching, and pagination)
3. Viewing product details.
4. Update an existing product.
5. Logout




## ShopifyFrontEnd Application- Main Features:
- Authentication and Authorization.
- Managing their accounts.
- Make a payment via PayPal, Credit Card or Cash.
- Tracking their orders.	
  

### The following video demonstrates a number of actions a registered customer can take when using the site:

 1. login.
 2. Select Search Category (Laptops).
 3. Choose a product and add it to the shopping cart.
 4. Successful execution of an order via paypal.
 5. Keeps track of the status of the order.
 6. Logout





https://user-images.githubusercontent.com/67732785/135839246-a8ec6fc8-1ba8-48df-b8ca-824976c7be4a.mp4




	
## Quick Start - How to access the 2 running applications on the Heroku cloud platform?


### Access to the ShopifyFrontEndProject - Instructions

   Open the home page By clicking on the following link: [ShopifyFrontEnd Home Page ](https://shopify100.com) \
   Yod will see the following page:
   </br>
   </br>

   <center>
   <img src="documents/images/shopify-frontend/login/documents/images/shopify-frontend/login/shopme-frontend-homepage-before-login.png" width=800 height=400 />
   </center>

   At this point, you are a "visitor".
   You can login to the app as an existed customer by clicking on the "login" link on the top right corner of the home page.
   You will see the the login page: 

   <br/>
   <br/>

   <center>
            <img src="documents/images/shopify-frontend/login/shopify-frontend-login-page.png" width=800 height=400 />
    </center>
  

   Use the following Credentials to login: 
   <br/>


            |     Username             |   Password      |  
            |--------------------------|-----------------|
            |`githubcustomer@gmail.com`|  `github2021`   |
         
      
  <br/>       
   
Alternatively - If you are not a registered customer - you can still login by using your own Google or Facebook accounts from the login page.

<br/>

<br/> 
 <b>Congradiulations!</b> You are logged in succesfully to the shopify-front-end applicatoin: You will see the home page with your user name on the top left corner:

<br/>
<br/>
   
   <center>
   <img src="documents/images/shopify-frontend/login/documents/images/shopify-frontend/login/shopify-frontend-homepage-after-login.png" width=800 height=400 />
   </center>


<hr>
<br/>

### Access to the ShopifyBackEndProject - Instructions

   Open the login page By clicking on the following link: [ShopifyBackEnd Login Page ](https://admin.shopify100.com) 
   Yod will see the following page: 
   </br>
   </br>

   <center>
   <img src="documents/images/shopify-backend/login/shopify-admin-login-page.png" width=800 height=400 />
   </center>
  

   </br>
   <br/>
   Use Must have credentials of some Role(Admin, Saleperson,Editor, Shipper , Assistance) in order to access the application. 
   <br/>
   Use the following Credentials to login as an admin user in order to get full controll:
   <br/>
   <br/>  

             |     Username          | Password   |     Role     |
             |-----------------------|------------|--------------|
             |`githubadmin@gmail.com`|`github2021`|  `Admin`     |

    
   <b>Congradiulations!</b> You are logged in succesfully to the ShopifyBackEnd applicatoin
    <br/>
      <b>NOTE:</b> This is the admin hompepage after clicking on the "products" link in order to view the ilst of all proudcts
      

   <br/>
   <br/>
  
   <center>
            <img src="documents/images/shopify-backend/login/shopify-admin-home-page-after-login.png" width=800 height=400 />
    </center>

   <br/>
   
   #### Video Demo:

The following video demonstrates the process by which the customer logs in to the app, selects a category of laptops, selects a computer, adds to the shopping cart, successfully places an order through paypal and finally checks the order status.



   <br/>
   <br/>     


<!-- APPLICATION SCREENSHOTS -->



<!-- **More [Screenshots](documents/SCREENSHOTS.MD)** -->

## Details


- [Getting Started](documents/GETTING_STARTED.MD)  
- [Installation](documents/INSTALLATION.MD)  

   

<!-- - [Technology stack & other Open-source libraries](documents/TECHNOLOGY_STACK.MD)  
- [Technical Functionalities and To-Do](documents/TECHNICAL_FUNCTIONALITIES.MD)  
- [Getting Started](documents/GETTING_STARTED.MD)  
- [Architecture](documents/ARCHITECTURE.md) 
- [Installation](documents/INSTALLATION.MD)  
- [Deployment](documents/DEPLOYMENT.md)  
- [Security](documents/API.md)  
- [Testing API](documents/TESTING.MD)  
- [Changelog](documents/CHANGELOG.md) 
- [Code Coverage](documents/CODE_COVERAGE.MD) 
- [Documentation](documents/DOCUMENTATION.MD) 
    -->
  

