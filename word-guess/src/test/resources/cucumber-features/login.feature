Feature: Login
	It allows a player to be authenticated in order to
	play games later.
	
	The player test credentials are:
		-username: testuser
		-password: test1234
	
	Scenario: Successful login
		Given the username "testuser"
		And the password "test1234"
		When the user tries to log in
		Then the system logs the user in
	
	Scenario: Non-existent username
		Given the username "foonouser"
		And the password "whateverpassword"
		When the user tries to log in
		Then the system warns that no such username exists
	
	Scenario: Invalid password
		Given the username "testuser"
		And the password "foowrongpassword"
		When the user tries to log in
		Then the system refuses to log the user in