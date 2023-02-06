docker build -t egame-darling-image ./Dockerfile
docker stop egameDarlingContainer
docker rm egameDarlingContainer
docker run -d --name egameDarlingContainer -p 3306:3306 egame-darling-image
docker exec -it egameDarlingContainer bash
Rem mysql -u root -pTestPW
Rem ALTER USER 'root'@'localhost' IDENTIFIED WITH mysql_native_password BY 'TestPW'
pause