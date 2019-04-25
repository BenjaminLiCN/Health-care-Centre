# Health-care Centre
Java-web project for SWEN90016

Now the main structure is all set up, waiting for configuring exact demands.

Go to this doc to view tasks, please highlighten the task if you want to do it. Make sure you check this file every time you start developing something.
```
https://docs.google.com/document/d/1jtLSB1C9s5afOT8EsTq6gds-qNJhTuMlSe_XlBzNVh0/edit?usp=sharing
```

For Back end developer, add pom.xml to Maven and then run src/main/java/com.benjamin.hcc/hccApplication.java to start.

For Front end developer, go to src/main/resources/static, in the terminal, run
```
npm install
npm run
```
to deploy the front end to your localhost

The gulpfile.js will readin all the necessary dependencies like css, scss, js files and generate a vendor folder under the root directory. You should start looking at main.js to understand how it works.

Note that /Users/Benjamin/Health-care-Centre/src/main/java/com/benjamin/hcc/security/WebSecurityConfig.java is controlling all the resources, you might want to include any files you newly created here.
