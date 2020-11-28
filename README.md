# Powerpoint presentation notes extractor.
  This program takes a .pptx file location as a parameter. It creates a "Script" directory, which has all of the notes from the presentation extracted in separate .txt files
## 1. Prerequisites
  - Java 8 newer
  - Maven

## 2. How to run
  1. Change the `PRESENTATION_LOCATION` constant in Convertor.java to point to the .pptx file. There you`ll later find the "Script" folder with the .txt files 
  2. run: `mvn clean install`
  3. run: `mvn exec:java`
