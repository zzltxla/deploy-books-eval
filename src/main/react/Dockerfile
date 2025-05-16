FROM node:23.10-alpine3.21 AS build

WORKDIR /react

COPY package.json package-lock.json /react/

RUN npm i

COPY . . 

RUN npm run build

FROM nginx:stable-alpine3.21-perl 

WORKDIR /app

COPY --from=build /react/dist/ /usr/share/nginx/html

CMD ["nginx", "-g", "daemon off;"]