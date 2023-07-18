Feature: To validate the registration functionality of the facebook application
Scenario: To create new account
Given To launch the browser and maximise it
When To launch the facebook application
And To click the create new account button
#one diamentional map data
And To pass the first name in first name box
#key				value
|firstName1|bala|
|firstName2|rahini|
|firstName3|rahibala|
And to pass the second name in second name box

#two diamentional map data
And To pass mobile no or email id in mobile number box

|password1|password2|password3|
|7876567898|inmakes@gmail.com|javapython@gmail.com|
|nanmahanalla@gmail.com|9098767899|6789898767|
|ksjbk648|jksn983639|987398j@|
|678765678hgvb|'lkdnonlds098|lksdif|

And To create new password using new password box
Then To close the browser  

