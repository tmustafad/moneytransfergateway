# moneytransfergateway

mvn exec:java -DshowHsqlViewer=no

mvn -Dtest=MoneyTransferApiTests test




#  moneytransfergateway


## The Goal


### Prerequisites



### Installing



## The Endpoints to reach after running the project
| Method        | Path          										                  |Usage
| ------------- | ----------------------------------------------------------------------  |------------------------ 										|
| GET           | http://localhost:7777/transferGateway/getAllCustomers                   |get all Customers
| GET           | http://localhost:7777/transferGateway/getAllAccounts                    |get all Accounts     
| POST          | http://localhost:7777/transferGateway/createAccount                     |create a new Account
| POST          | http://localhost:7777/transferGateway/createCustomer                    |create a new Customer
| DELETE        | http://localhost:7777/transferGateway/deleteCustomer                    |delete customer
| DELETE        | http://localhost:7777/transferGateway/deleteAccount                     |delete account 
| PUT           | http://localhost:7777/transferGateway/transferMoney/<from>/<to>/<amount>|transfer money from one account to other
| DELETE        | http://localhost:7777/transferGateway/deleteCustomer                    |delete customer
| DELETE        | http://localhost:7777/transferGateway/deleteAccount                     |delete account                                        |

## Running the tests



## Deployment



