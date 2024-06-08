INSERT INTO "roles" VALUES ('USER', 'user') ON CONFLICT ("id") DO UPDATE SET "name" = EXCLUDED."name";
INSERT INTO "roles" VALUES ('MD', 'medic') ON CONFLICT ("id") DO UPDATE SET "name" = EXCLUDED."name";
INSERT INTO "roles" VALUES ('SUDO', 'sysadmin') ON CONFLICT ("id") DO UPDATE SET "name" = EXCLUDED."name";