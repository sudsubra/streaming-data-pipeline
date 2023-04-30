# Overview

By now you've seen some different Big Data frameworks such as Kafka and Spark. Now we'll be focusing in on HBase. In this homework, your
challenge is to write answers that make sense to you, and most importantly, **in your own words!**
Two of the best skills you can get from this class are to find answers to your questions using any means possible, and to
reword confusing descriptions in a way that makes sense to you. 

### Tips
* You don't need to write novels, just write enough that you feel like you've fully answered the question
* Use the helpful resources that we post next to the questions as a starting point, but carve your own path by searching on Google, YouTube, books in a library, etc to get answers!
* We're here if you need us. Reach out anytime if you want to ask deeper questions about a topic 
* This file is a markdown file. We don't expect you to do any fancy markdown, but you're welcome to format however you like


### Your Challenge
1. Create a new branch for your answers 
2. Complete all of the questions below by writing your answers under each question
3. Commit your changes and push to your forked repository

## Questions
#### What is a NoSQL database? 
Databases that store data in a format other than relational tables.
Over time, four major types of NoSQL databases emerged: 
document databases, key-value databases, wide-column stores, and graph databases.
* Document databases store data in documents similar to JSON (JavaScript Object Notation) objects. 
Each document contains pairs of fields and values. The values can typically be a variety of types 
including things like strings, numbers, booleans, arrays, or objects.
* Key-value databases are a simpler type of database where each item contains keys and values.
* Wide-column stores store data in tables, rows, and dynamic columns.
* Graph databases store data in nodes and edges. Nodes typically store information about people, 
places, and things, while edges store information about the relationships between the nodes.

#### In your own words, what is Apache HBase? 
Apache HBase is a distributed column-oriented database that is built on top of the Hadoop file systems. 
It is modeled after Google Bigtable and written in Java. Column oriented databases are databases that 
organize data by field, keeping all of the data associated with a field next to each other in memory.

#### What are some strengths and limitations of HBase? 
* [HBase By Examples](https://sparkbyexamples.com/apache-hbase-tutorial/)
* Pros (resources:https://www.codingninjas.com/codestudio/library/hbase-pros-cons)
  * Handle large amount of data:  It is schema-less and provides quick access to the data from billions 
of records present in the database. Since it is schema-less, we do not have columns in HBase. Rather, 
we have column families. The column families can have different attributes. Also, each row is not required 
to have exact column family qualifiers.
  * Speed: The feature of random access in Hbase is one of the its key features and enhances it performance.
  * Scalable: It is linearly scalable. The schema flexibility is because of the column-oriented database. 
It supports variable schema. The columns can be modified (added/ removed) very easily.
  * Java API for client access: It provides Java API for clients to process huge amounts of data. The Java 
API  includes all Java packages, classes, interfaces, methods, fields, and constructors, which can be used 
by the clients.
* Cons:
  * No easy replacement: Not a best replacement for traditional models due to not supported by the Hbase
  * Not like SQL: Querying not as simple as SQL and does nor contain query optimizer
  * No transaction feature: Does not provide a mechanism to start a transaction and roll back
  * It does not support JOIN operation: 
  * Expensive: It is expensive in terms of hardware requirements and memory blocks allocations
  * No default indexing: One has to manually perform the indexing. Another disadvantage is that there 
cannot be more than one indexing in the table. Only the row key column acts as a primary key in HBase

#### Explain the following concepts: 
* Rowkey: Can be looked as a row identifier to a data in a traditional databases. It is always unique and
can be any arbitrary array of bytes. 
* Column Qualifier: Column names. Column qualifiers are mutable and may differ greatly between rows.
* Column Family: Group of column qualifiers that have the same access patterns. Must be defined when a table
is created. Number of column families should be limited to no more than 2 or 3 for storage efficiency. 


#### What are the differences between Get and Put commands in HBase? 
* [HBase commands](https://www.tutorialspoint.com/hbase/hbase_create_data.htm)
* The **Put** command is used to adds new rows to a table or can update existing row
* The **Get** command is used to retrieve contents of a row


#### What is the HBase Scan command for? 
* [HBase Scan](https://www.tutorialspoint.com/hbase/hbase_scan.htm)
Scan is used to get data from the HBase table. By default, it fetches all data from the table. Allow 
iteration over multiple rows for a specified attributes. Another example resources: 
https://sparkbyexamples.com/hbase/hbase-scan-or-select-the-table/

#### What was the most interesting aspect of HBase when went through all the questions? 
Hbase database does not have schema. Also, how the data is 
organized with Rowkey, column qualifier and column family for improved efficiency and dealing with large 
sparsely populated tables. 