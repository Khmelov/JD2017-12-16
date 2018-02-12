cd .
FOR %%I In (*.txt) DO (
"C:\Program Files (x86)\Java\jdk1.8.0_152\bin\native2ascii.exe" -encoding utf-8 %%I %%~nI.properties
)
