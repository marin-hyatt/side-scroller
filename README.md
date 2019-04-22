# side-scroller
A side-scroller obstacle game, inspired by the no Internet dino game.

# changelog
## [x.x.x] 2019-21-4
### Added
- Application.java file created to run main method.

### Changed
- Moved main method out of ScoreTimer.java.

## [x.x.x] 2019-20-4
### Added
- ScoreTimer.java file.

### Changed
- Score is now kept using javax.swing.Timer.

### Removed
- ScoreDisplayer.java's use of Thread was badly designed.
- ScoreDisplayerTester.java removed.

## [x.x.x] 2019-19-4
### Added
- ScoreDisplayer.java updates a JLabel with a score at a constant interval.
- ScoreDisplayerTester.java starts, stops, and resets score counting with two JButtons.
