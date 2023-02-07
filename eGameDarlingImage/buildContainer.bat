docker build -t egame-darling-image ./Dockerfile
docker stop egameDarlingContainer
docker rm egameDarlingContainer
docker run -d --name egameDarlingContainer -p 33060:33060 egame-darling-image