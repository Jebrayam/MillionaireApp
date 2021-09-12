# MillionaireApp
MillionaireApp models a Q&A contest in a Console UI, the aim is to implement a solution designed to allow having a question bank with different options and unique right anwser. Each question has a category in which the difficulty level is the same for all questions. The game is played in five rounds, so a reward is won in each of them. Round's level increases the difficulty of the game and therefore the amount of the reward.

The logic of development is performed in based at the followig ER diagram:

![MillionaireModelER](https://user-images.githubusercontent.com/57733110/132990184-5615efc6-0459-4245-abcf-5f720ea4e723.png)

The implementation makes use of the OOP modelling, data persistence, and manegement of data trhough list and control loops. The above implemented using Java and MySQL. JDBC API is used to set the connection between the app and the DB.

# Running App
To execute de app, please run the **Main.java** file located in the folder path **src/millionaireapp**.

# DB Setting
Create a new connection in MySQL and execute all the queries in **src/utils/createSchema.sql**. Then edit the credentials in **db_credentials.json** to your own DB credentials. Finally, as the app is developed in Netbeans 12.0 and JDK11, please try to use them as well and from the IDE add the following libraries stored in **libs** to the JAR/Folder: **json-simple-1.1.1** and **mysql-connector-java-8.0.26**.

