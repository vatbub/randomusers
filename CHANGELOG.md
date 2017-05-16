# v1.3
- Refactored the `Nationality`-interface to be a abstract class instead of a interface. All methods from `InternalNationality` were moved to `Nationality`. This allowed us to remove the `InternalNationality`-class and means for you that you might have to change some syntax. Just recompile the project after upgrading and you wil find all locations where you need to update your code. Code completion should guide you through all fixes you need to do.
- Fixed [#1](https://github.com/vatbub/randomusers/issues/1) (Encoding of the resource files which resultet in bad encoded names and addresses)

# v1.2
- Added the possibility to get a nationality from the current locale

# v1.1
- Implemented avatar-images

# v1.0
- Initial release