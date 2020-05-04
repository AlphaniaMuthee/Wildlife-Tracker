# The Wildlife Tracker
## Author 
<a href="https://github.com/AlphaniaMuthee">Alphania Muthee</a>
## Description
This app will help rangers from a forest service  in sighting and recording safe and endangered animals in the forest. The rangers are also able to view the animals they have recorded.
## Technologies
* Java/Spark
* HTML
* Bootstrap
* PostgreSql, as the database

## Database recreation
Launch psql and run the following commands to generate the database for the app.
* CREATE DATABASE wildlife_tracker;
* \c wildlife_tracker;
* CREATE TABLE animals (id serial PRIMARY KEY, name varchar);
* CREATE TABLE endangered (id serial PRIMARY KEY ,name varchar,age varchar,health varchar);
* CREATE  TABLE  sightings (id serial PRIMARY KEY ,ranger varchar,date timestamp);
* CREATE DATABASE wildlife_tracker_test WITH TEMPLATE wildlife_tracker;

## Setup Requirements 
A search engine and the link to the app provided below:

## Support and contact Details
For queries or more information, contact me through any of the following:
* on twitter @AlphaniaC
* email walphania2@gmail.com
## License
MIT License

Copyright (c) 2020 Alphania Muthee Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.