USE `boutique-hotel-technikum-db`;

# seed rooms
INSERT INTO rooms (room_id, description, name)
VALUES (1, 'Ein Standard Doppelzimmer im ersten Stock mit einem King-Size Bed, einer geräumigen Dusche, Minibar und vieles mehr.', 'Standard Doppelzimmer');
INSERT INTO rooms (room_id, description, name)
VALUES (2, 'Ein Dreibettzimmer ideal für frisch gebackene Familien mit dem tollen Kinderbett im großen Schlafzimmer.
Es befindet sich auch eine Couch im Schlafzimmer die bei 3 Erwachsenen Gästen als drittes Bett fungiert.', 'Dreibett Zimmer');
INSERT INTO rooms (room_id, description, name)
VALUES (3, 'Unser Deluxe Doppelzimmer überzeugt mit einem großen Balkon, großen Glasfronten mit wundervoller Aussicht auf die FH Technikum,
Minibar, Panoramadusche sow einer zusätzlichen Badewanne und vielem mehr.', 'Deluxe Doppelzimmer');
INSERT INTO rooms (room_id, description, name)
VALUES (4, 'Das Standard Apartment überzeugt mit einer großen Küche, zwei Schlafzimmern mit zwei separaten WCs und einem gemeinsamen Bad,
einer voll ausgestatteten Küche mit allem was man zum Kochen braucht. EinSupermarkt befindet sich gleich hinter dem Hotel', 'Standard Apartment');
INSERT INTO rooms (room_id, description, name) VALUES (5, 'Demo Beschreibung 5', 'Demo Zimmer');
INSERT INTO rooms (room_id, description, name) VALUES (6, 'Demo Beschreibung 6', 'Demo Zimmer');
INSERT INTO rooms (room_id, description, name) VALUES (7, 'Demo Beschreibung 7', 'Demo Zimmer');
INSERT INTO rooms (room_id, description, name) VALUES (8, 'Demo Beschreibung 8', 'Demo Zimmer');
INSERT INTO rooms (room_id, description, name) VALUES (9, 'Demo Beschreibung 9', 'Demo Zimmer');
INSERT INTO rooms (room_id, description, name) VALUES (10, 'Demo Beschreibung 10', 'Demo Zimmer');
INSERT INTO rooms (room_id, description, name) VALUES (11, 'Demo Beschreibung 11', 'Demo Zimmer');
INSERT INTO rooms (room_id, description, name) VALUES (12, 'Demo Beschreibung 12', 'Demo Zimmer');
INSERT INTO rooms (room_id, description, name) VALUES (13, 'Demo Beschreibung 13', 'Demo Zimmer');
INSERT INTO rooms (room_id, description, name) VALUES (14, 'Demo Beschreibung 14', 'Demo Zimmer');
INSERT INTO rooms (room_id, description, name) VALUES (15, 'Demo Beschreibung 15', 'Demo Zimmer');
INSERT INTO rooms (room_id, description, name) VALUES (16, 'Demo Beschreibung 16', 'Demo Zimmer');
INSERT INTO rooms (room_id, description, name) VALUES (17, 'Demo Beschreibung 17', 'Demo Zimmer');
INSERT INTO rooms (room_id, description, name) VALUES (18, 'Demo Beschreibung 18', 'Demo Zimmer');
INSERT INTO rooms (room_id, description, name) VALUES (19, 'Demo Beschreibung 19', 'Demo Zimmer');
INSERT INTO rooms (room_id, description, name) VALUES (20, 'Demo Beschreibung 20', 'Demo Zimmer');
INSERT INTO rooms (room_id, description, name) VALUES (21, 'Demo Beschreibung 21', 'Demo Zimmer');
INSERT INTO rooms (room_id, description, name) VALUES (22, 'Demo Beschreibung 22', 'Demo Zimmer');
INSERT INTO rooms (room_id, description, name) VALUES (23, 'Demo Beschreibung 23', 'Demo Zimmer');

# seed room images
INSERT INTO room_images (room_image_id, image_path, room_id) VALUES (1, 'RoomImage1', 1);
INSERT INTO room_images (room_image_id, image_path, room_id) VALUES (2, 'RoomImage2', 1);
INSERT INTO room_images (room_image_id, image_path, room_id) VALUES (3, 'RoomImage3', 2);
INSERT INTO room_images (room_image_id, image_path, room_id) VALUES (4, 'RoomImage4', 3);
INSERT INTO room_images (room_image_id, image_path, room_id) VALUES (5, 'RoomImage5', 3);
INSERT INTO room_images (room_image_id, image_path, room_id) VALUES (6, 'RoomImage6', 3);
INSERT INTO room_images (room_image_id, image_path, room_id) VALUES (7, 'RoomImage7', 4);

# seed characteristics
INSERT INTO characteristics (characteristic_id, name) VALUES (1, 'Minibar');
INSERT INTO characteristics (characteristic_id, name) VALUES (2, 'Küche');
INSERT INTO characteristics (characteristic_id, name) VALUES (3, 'Badewanne');
INSERT INTO characteristics (characteristic_id, name) VALUES (4, 'Dusche');
INSERT INTO characteristics (characteristic_id, name) VALUES (5, 'WLAN');
INSERT INTO characteristics (characteristic_id, name) VALUES (6, 'Nichtraucherzimmer');
INSERT INTO characteristics (characteristic_id, name) VALUES (7, 'Balkon');
INSERT INTO characteristics (characteristic_id, name) VALUES (8, 'TV');
INSERT INTO characteristics (characteristic_id, name) VALUES (9, 'Waschmaschine');
INSERT INTO characteristics (characteristic_id, name) VALUES (10, 'Handtücher');
INSERT INTO characteristics (characteristic_id, name) VALUES (11, 'Klimaanalage');
INSERT INTO characteristics (characteristic_id, name) VALUES (12, 'Heizung');
INSERT INTO characteristics (characteristic_id, name) VALUES (13, 'Kinderbett');
INSERT INTO characteristics (characteristic_id, name) VALUES (14, 'Bad und WC getrennt');

# seed room_to_characeteristics
INSERT INTO room_to_characteristics (room_id, characteristic_id) VALUES (1, 1);
INSERT INTO room_to_characteristics (room_id, characteristic_id) VALUES (1, 4);
INSERT INTO room_to_characteristics (room_id, characteristic_id) VALUES (1, 5);
INSERT INTO room_to_characteristics (room_id, characteristic_id) VALUES (1, 6);
INSERT INTO room_to_characteristics (room_id, characteristic_id) VALUES (1, 8);
INSERT INTO room_to_characteristics (room_id, characteristic_id) VALUES (1, 10);
INSERT INTO room_to_characteristics (room_id, characteristic_id) VALUES (1, 11);
INSERT INTO room_to_characteristics (room_id, characteristic_id) VALUES (1, 12);

INSERT INTO room_to_characteristics (room_id, characteristic_id) VALUES (2, 4);
INSERT INTO room_to_characteristics (room_id, characteristic_id) VALUES (2, 5);
INSERT INTO room_to_characteristics (room_id, characteristic_id) VALUES (2, 6);
INSERT INTO room_to_characteristics (room_id, characteristic_id) VALUES (2, 8);
INSERT INTO room_to_characteristics (room_id, characteristic_id) VALUES (2, 10);
INSERT INTO room_to_characteristics (room_id, characteristic_id) VALUES (2, 11);
INSERT INTO room_to_characteristics (room_id, characteristic_id) VALUES (2, 12);
INSERT INTO room_to_characteristics (room_id, characteristic_id) VALUES (2, 13);

INSERT INTO room_to_characteristics (room_id, characteristic_id) VALUES (3, 1);
INSERT INTO room_to_characteristics (room_id, characteristic_id) VALUES (3, 3);
INSERT INTO room_to_characteristics (room_id, characteristic_id) VALUES (3, 4);
INSERT INTO room_to_characteristics (room_id, characteristic_id) VALUES (3, 5);
INSERT INTO room_to_characteristics (room_id, characteristic_id) VALUES (3, 6);
INSERT INTO room_to_characteristics (room_id, characteristic_id) VALUES (3, 7);
INSERT INTO room_to_characteristics (room_id, characteristic_id) VALUES (3, 8);
INSERT INTO room_to_characteristics (room_id, characteristic_id) VALUES (3, 10);
INSERT INTO room_to_characteristics (room_id, characteristic_id) VALUES (3, 11);
INSERT INTO room_to_characteristics (room_id, characteristic_id) VALUES (3, 12);

INSERT INTO room_to_characteristics (room_id, characteristic_id) VALUES (4, 1);
INSERT INTO room_to_characteristics (room_id, characteristic_id) VALUES (4, 2);
INSERT INTO room_to_characteristics (room_id, characteristic_id) VALUES (4, 3);
INSERT INTO room_to_characteristics (room_id, characteristic_id) VALUES (4, 4);
INSERT INTO room_to_characteristics (room_id, characteristic_id) VALUES (4, 5);
INSERT INTO room_to_characteristics (room_id, characteristic_id) VALUES (4, 6);
INSERT INTO room_to_characteristics (room_id, characteristic_id) VALUES (4, 8);
INSERT INTO room_to_characteristics (room_id, characteristic_id) VALUES (4, 9);
INSERT INTO room_to_characteristics (room_id, characteristic_id) VALUES (4, 10);
INSERT INTO room_to_characteristics (room_id, characteristic_id) VALUES (4, 11);
INSERT INTO room_to_characteristics (room_id, characteristic_id) VALUES (4, 12);
INSERT INTO room_to_characteristics (room_id, characteristic_id) VALUES (4, 14);










