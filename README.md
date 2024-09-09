# Let Em Cook API

A Java spring boot REST API server that serves data from postgresDB.

Creating a java REST API because functions can only do so much and the supabase javascript backend - Deno is kinda new.

## Run the application

Do these in your local to run the application:

1. create a postgres local db in docker using this command
   ```shell
      docker run --name let-em-cook-db -e POSTGRES_USER=developer -e POSTGRES_PASSWORD=developer -p 5432:5432 -d postgres:16.4 
    ```
2. 