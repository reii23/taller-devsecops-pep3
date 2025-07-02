
echo "Configurando Docker-in-Docker para Jenkins..."

echo "Verificando Docker daemon..."
if ! systemctl is-active --quiet docker; then
    echo "Iniciando Docker..."
    sudo systemctl start docker
    sudo systemctl enable docker
fi

echo "Configurando permisos del socket Docker..."
sudo chmod 666 /var/run/docker.sock

echo "Deteniendo contenedores actuales..."
docker compose down 2>/dev/null || true

echo "Levantando Jenkins y SonarQube..."
docker compose up -d

echo "Esperando a que Jenkins este listo..."
sleep 30

echo "Instalando Docker CLI en Jenkins..."
docker exec jenkins bash -c "apt-get update && apt-get install -y docker.io" 2>/dev/null

echo "Verificando configuracion..."
if docker exec jenkins docker --version; then
    echo ""
    echo "Docker-in-Docker configurado correctamente"
    echo "Acceso: http://$(hostname -I | awk '{print $1}'):8082"
    echo "Contrasena Jenkins: docker logs jenkins"
else
    echo "Error en la configuracion. Revisar: docker logs jenkins"
fi
