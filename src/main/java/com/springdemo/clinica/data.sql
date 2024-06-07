INSERT INTO "sec01_roles" VALUES ('USER', 'user') ON CONFLICT ("id") DO UPDATE SET "name" = EXCLUDED."name";
INSERT INTO "sec01_roles" VALUES ('MD', 'medic') ON CONFLICT ("id") DO UPDATE SET "name" = EXCLUDED."name";
INSERT INTO "sec01_roles" VALUES ('SUDO', 'sysadmin') ON CONFLICT ("id") DO UPDATE SET "name" = EXCLUDED."name";