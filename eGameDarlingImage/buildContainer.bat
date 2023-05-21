docker build -t egame-darling-image ./Dockerfile
docker stop egameDarlingContainer
docker rm egameDarlingContainer
docker run -d --name egameDarlingContainer -p 3306:3306 egame-darling-image