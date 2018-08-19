call npm run-script build:prod
del C:\nginx-1.13.8\web-english /q
copy C:\Users\IRBIS\IdeaProjects\web-english\english-client\dist C:\nginx-1.13.8\web-english
