FROM mcr.microsoft.com/mssql/server:2019-latest

ENV ACCEPT_EULA=Y
ENV SA_PASSWORD=StrongP4ssword#

WORKDIR /usr/src/app

CMD /opt/mssql/bin/sqlservr