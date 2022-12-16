create table if not exists SocksMainTable
(
    socks_color  varchar(256),
    socks_cotton integer CHECK (SocksMainTable.socks_cotton > 0) CHECK (SocksMainTable.socks_cotton <= 100 ) default 100,
    PRIMARY KEY (socks_color, socks_cotton),
    socks_count  integer not null CHECK (SocksMainTable.socks_count > 0) default 1
);








