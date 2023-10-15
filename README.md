# Individual Project(CMPE-202)<br>
Name: Dhruva Gajera<br>
Student ID: 016040934

## Credit Card Problem<br> 


## 1. Describe what is the primary problem you try to solve.<br>
**Ans:** The primary problem that I am trying to solve in this project is to come up with an idea of design patterns which will help me to classify cards based on the validation tests performed on them and also at the same time generate classes based on the type keeping the code available for extension but unavailable for alteration.<br><br>

## 2. Describe what type of secondary problem you try to solve.<br>
**Ans:** Other type of secondary problem that I am trying to solve is to come up with an idea for developing strategies to validate different types of card and also parsing different types of files.<br><br>

## 3. Describe what type of design patterns you use.<br>
**Ans:** For this problem I am thinking to use four different types of
### design patterns described below:<br><br>
**Chain of responsibility**: I come up with an idea to use this pattern in order to determine the type of card by passing to a chain of validators. If the type matches, these validators will return true, and if the type does not match, it will pass to the next type.<br><br>
**Factory**: I used this pattern to create instances of different types of card.<br><br>
**Strategy**: For various strategies to parse the different type of card.<br><br>
**Adaptor**: For different types of files to parse.<br><br>

## 4. Describe the consequences of using this pattern.<br>
**Ans:**
1. No change in current strategies to include new strategies
2. No Switch or if else loop to check card type
3. Code extension to add new file parsing
4. No if else to create concrete classes 
