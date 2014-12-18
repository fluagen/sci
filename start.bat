set ini_memory=256m
set max_memory=512m
java -cp "libs/*" -Xms%ini_memory%  -Xmx%max_memory% com.sci.app.MainApp -os win32 -ws win32 -arch x86 -console