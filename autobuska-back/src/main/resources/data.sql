INSERT INTO prevoznik (naziv, adresa, pib) VALUES ('MacvaExpress', 'Radnicka 15', '123');
INSERT INTO prevoznik (naziv, adresa, pib) VALUES ('Lasta', 'Vincanska 11', '5823');
INSERT INTO prevoznik (naziv, adresa, pib) VALUES ('Raketa', 'Badanjska 9', '468');

INSERT INTO linija (br_mesta, cena_karte, vr_polaska, destinacija, prevoznik_id) VALUES (60, 450.00, '16:00', 'Sabac - Novi Sad', 1);
INSERT INTO linija (br_mesta, cena_karte, vr_polaska, destinacija, prevoznik_id) VALUES (45, 300.00, '12:00', 'Loznica - Sabac', 2);
INSERT INTO linija (br_mesta, cena_karte, vr_polaska, destinacija, prevoznik_id) VALUES (50, 400.00, '14:00', 'Beograd - Kragujevac', 1);
INSERT INTO linija (br_mesta, cena_karte, vr_polaska, destinacija, prevoznik_id) VALUES (60, 350.00, '11:00', 'Sabac - Beograd', 3);

INSERT INTO rezervacija (id, br_putnika, linija_id) VALUES (1, 45, 1);
INSERT INTO rezervacija (id, br_putnika, linija_id) VALUES (2, 25, 2);

INSERT INTO `user` (id, username, password, role)
              VALUES (1,'miroslav','$2y$12$NH2KM2BJaBl.ik90Z1YqAOjoPgSd0ns/bF.7WedMxZ54OhWQNNnh6','ADMIN');
INSERT INTO `user` (id, username, password, role)
              VALUES (2,'tamara','$2y$12$DRhCpltZygkA7EZ2WeWIbewWBjLE0KYiUO.tHDUaJNMpsHxXEw9Ky','KORISNIK');
INSERT INTO `user` (id, username, password, role)
              VALUES (3,'petar','$2y$12$i6/mU4w0HhG8RQRXHjNCa.tG2OwGSVXb0GYUnf8MZUdeadE4voHbC','KORISNIK');

