
        $('a').click(function (e) {
          e.preventDefault();
          var answer = $(this).next('.answer');
          var allAnswers = $('.answer');

          allAnswers.not(answer).stop(true, true).animate({
            maxHeight: '0',
            opacity: 0
          }, 500);

          if (answer.css('max-height') === '0px' || answer.css('opacity') === '0') {
            answer.stop(true, true).animate({
              maxHeight: answer.prop('scrollHeight') + 'px',
              opacity: 1
            }, 500);
          } else {
            answer.stop(true, true).animate({
              maxHeight: '0',
              opacity: 0
            }, 500);
          }
        });

