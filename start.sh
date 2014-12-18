set ini_memory=256m
set max_memory=512m
java -cp "libs/*" -Xms%ini_memory%  -Xmx%max_memory% com.sci.app.MainApp -console