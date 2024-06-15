USE `boutique-hotel-technikum-db`;

# Clear existing data
DELETE FROM bookings_to_rooms;
DELETE FROM guest_to_bookings;
DELETE FROM bookings;
DELETE FROM guests;
DELETE FROM room_to_characteristics;
DELETE FROM characteristics;
DELETE FROM room_images;
DELETE FROM rooms;

# Seed rooms
INSERT INTO rooms (room_id, description, name)
VALUES (1, 'Ein Standard Doppelzimmer im ersten Stock mit einem King-Size Bed, einer geräumigen Dusche, Minibar und vieles mehr.', 'Standard Doppelzimmer');
INSERT INTO rooms (room_id, description, name)
VALUES (2, 'Ein Dreibettzimmer ideal für frisch gebackene Familien mit dem tollen Kinderbett im großen Schlafzimmer. Es befindet sich auch eine Couch im Schlafzimmer die bei 3 Erwachsenen Gästen als drittes Bett fungiert.', 'Dreibett Zimmer');
INSERT INTO rooms (room_id, description, name)
VALUES (3, 'Unser Deluxe Doppelzimmer überzeugt mit einem großen Balkon, großen Glasfronten mit wundervoller Aussicht auf die FH Technikum, Minibar, Panoramadusche sow einer zusätzlichen Badewanne und vielem mehr.', 'Deluxe Doppelzimmer');
INSERT INTO rooms (room_id, description, name)
VALUES (4, 'Das Standard Apartment überzeugt mit einer großen Küche, zwei Schlafzimmern mit zwei separaten WCs und einem gemeinsamen Bad, einer voll ausgestatteten Küche mit allem was man zum Kochen braucht. Ein Supermarkt befindet sich gleich hinter dem Hotel', 'Standard Apartment');
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

# Seed room images
INSERT INTO room_images (room_image_id, filename, room_id, is_anchor) VALUES (1, 'RoomImage1.jpg', 1, true);
INSERT INTO room_images (room_image_id, filename, room_id, is_anchor) VALUES (2, 'RoomImage2.jpg', 1, false);
INSERT INTO room_images (room_image_id, filename, room_id, is_anchor) VALUES (3, 'RoomImage3.jpg', 2, true);
INSERT INTO room_images (room_image_id, filename, room_id, is_anchor) VALUES (4, 'RoomImage4.jpg', 3, true);
INSERT INTO room_images (room_image_id, filename, room_id, is_anchor) VALUES (5, 'RoomImage5.jpg', 3, false);
INSERT INTO room_images (room_image_id, filename, room_id, is_anchor) VALUES (6, 'RoomImage6.jpg', 3, false);
INSERT INTO room_images (room_image_id, filename, room_id, is_anchor) VALUES (7, 'RoomImage7.jpg', 4, true);

# Seed characteristics
INSERT INTO characteristics (characteristic_id, name, icon) VALUES (1, 'Minibar', 'mdi:local-bar');
INSERT INTO characteristics (characteristic_id, name, icon) VALUES (2, 'Küche', 'mdi:kitchen-counter');
INSERT INTO characteristics (characteristic_id, name, icon) VALUES (3, 'Badewanne', 'mdi:bathtub');
INSERT INTO characteristics (characteristic_id, name, icon) VALUES (4, 'Dusche', 'mdi:shower-head');
INSERT INTO characteristics (characteristic_id, name, icon) VALUES (5, 'WLAN', 'mdi:wifi');
INSERT INTO characteristics (characteristic_id, name, icon) VALUES (6, 'Nichtraucherzimmer', 'mdi:smoking-off');
INSERT INTO characteristics (characteristic_id, name, icon) VALUES (7, 'Balkon', 'mdi:balcony');
INSERT INTO characteristics (characteristic_id, name, icon) VALUES (8, 'TV', 'mdi:tv');
INSERT INTO characteristics (characteristic_id, name, icon) VALUES (9, 'Waschmaschine', 'mdi:washer');
INSERT INTO characteristics (characteristic_id, name, icon) VALUES (10, 'Doppelbett', 'mdi:bed-king');
INSERT INTO characteristics (characteristic_id, name, icon) VALUES (11, 'Klimaanalage', 'mdi:air-conditioner');
INSERT INTO characteristics (characteristic_id, name, icon) VALUES (12, 'Heizung', 'mdi:heating-coil');
INSERT INTO characteristics (characteristic_id, name, icon) VALUES (13, 'Kinderbett', 'mdi:human-male-female-child');
INSERT INTO characteristics (characteristic_id, name, icon) VALUES (14, 'Bad und WC getrennt', 'mdi:toilet');

# Seed room_to_characteristics
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

# Seed guests
INSERT INTO guests (guest_id, first_name, last_name, email) VALUES
(1, 'John', 'Doe', 'john.doe@example.com'),
(2, 'Jane', 'Smith', 'jane.smith@example.com');

# Seed bookings
INSERT INTO bookings (booking_id, booking_number, start_date, end_date, breakfast) VALUES
(1, 'BKG123', '2024-06-20', '2024-06-23', 1),
(2, 'BKG124', '2024-06-21', '2024-06-23', 0);

# Seed guest_to_bookings
INSERT INTO guest_to_bookings (booking_id, guest_id) VALUES
(1, 1),
(2, 2);

# Seed bookings_to_rooms
INSERT INTO bookings_to_rooms (booking_id, room_id) VALUES
(1, 1),
(2, 2);