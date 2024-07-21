if [ ! -d /backup ]; then
  echo "A pasta /backup não existe. Criando agora..."
  mkdir /backup
else
  echo "A pasta /backup já existe."
fi

trap 'DATE=$(date %H-%M-%S_%d-%m-%Y) && tar -cvf /backup/mariadb_backup_$DATE.tar /var/lib/mysql' SIGTERM

/usr/local/bin/docker-entrypoint.sh mariadbd &
PID=$!
wait $PID