

Feature: Assia customer MC Dashboard page
  Automating the tiles clicks and the page functionality check


  Scenario: Login and Tiles clicks
    Given Login select journey and refresh 
		When Click the My current speeds
		And Click the Get Started Banner
		And Click the My router tile
		And Click the Usage tile
		And Click the Connected Device tile
		And Click the My telephone tile
		And click the My tv tile
		Then click the Email service status tile
		

