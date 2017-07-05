# User schema

# --- !Ups
alter table `user` add `password` TEXT NOT NULL;


# --- !Downs
alter table `user` drop `password`;