# DB Design

## Rooms
> A physical room

| Column      | Type         | Null | Default       | Description           | 
|-------------|--------------|------|---------------|-----------------------|
| RoomId      | Int          | no   | autoincrement | PK                    |
| Name        | VarChar(265) | no   | ""            | name of a room        |
| Description | VarChar(265) | no   | ""            | description of a room |

## RoomImages
> An image of a room

| Column      | Type         | Null | Default       | Description                          | 
|-------------|--------------|------|---------------|--------------------------------------|
| RoomImageId | Int          | no   | autoincrement | PK                                   |
| RoomId      | Int          | no   |               | FK Rooms.RoomId                      |
| ImagePath   | VarChar(265) | no   | ""            | path to the image on the file system |

## Characteristics
> A characteristic a room may have

| Column           | Type        | Null | Default       | Description | 
|------------------|-------------|------|---------------|-------------|
| CharacteristicId | Int         | no   | autoincrement | PK          |
| Name             | VarChar(64) | no   | ""            | Unique      |

## RoomToCharacteristics
> Assignment of specific charateristics to a room

| Column           | Type | Nullable | Default | Description                         | 
|------------------|------|----------|---------|-------------------------------------|
| RoomId           | Int  | no       | null    | FK Rooms.RoomId                     |
| CharacteristicId | Int  | no       | null    | FK Characteristics.CharacteristicId |

## Guests
> A guest

| Column       | Type         | Nullable | Default       | Description                      | 
|--------------|--------------|----------|---------------|----------------------------------|
| GuestId      | Int          | no       | autoincrement | PK                               |
| FirstName    | VarChar(64)  | no       |               | firstname of guest               |
| LastName     | VarChar(64)  | no       |               | lastname of guest                |
| EMailAddress | VarChar(265) | no       |               | constraint: E-Mail Addressformat |

## Bookings
> A booking

| Column        | Type        | Nullable | Default       | Description                                                 | 
|---------------|-------------|----------|---------------|-------------------------------------------------------------|
| BookingId     | Int         | no       | autoincrement | PK                                                          |
| GuestId       | Int         | no       |               | FK Guests.GuestId                                           |
| BookingNumber | VarChar(64) | no       |               | UniqueKey, number of a booking for communication with guest |
| StartDate     | Date        | no       |               | start of booking                                            |
| EndDate       | Date        | no       |               | end of booking (constraint must be after StartDate)         |
| BreakFast     | TinyInt     | no       | 0             | 0 .. no breakfast wanted<br/>1 .. breakfast wanted          |

## BookingToRooms
> Assignment of a booking to the booked rooms

| Column    | Type | Nullable | Default | Description               | 
|-----------|------|----------|---------|---------------------------|
| BookingId | Int  | no       |         | PK1 FK Bookings.BookingId |
| RoomId    | Int  | no       |         | PK2 FK Rooms.RoomId       |