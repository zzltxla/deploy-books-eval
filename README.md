This app is written in Springboot JAVA 21 and React TS. It is conteneurized with [`Docker`](https://www.docker.com/) and uses [`Github Actions`](https://docs.github.com/en/actions). 

# GET STARTED 

## Build the container 

```bash
docker compose build
```

### Start the container 

```bash
docker compose up
# or if you wanna run it detached
docker compose up -d
```

## Github Actions' workflows

This Github CI works on push of a tag.

```bash
# Add your files 
git add .

# Commit with your message
git commit -m "your message"

# Add a version tag
git tag x.x.x 
# or
git tag x.x.xrcx

# Push to desired branch
git push origin desired-branch
```

Go to [http://localhost:8080](http://localhost:8080) with your browser to see the result.

You can now start editing the code to add modifications to the app.

This project uses [`PostgreSQL`](https://www.postgresql.org/) for the database.