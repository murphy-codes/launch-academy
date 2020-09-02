import React from "react"
import Enzyme, { mount } from "enzyme"
import { act } from "react-dom/test-utils"
import Adapter from "enzyme-adapter-react-16"

import Tweet from "./Tweet"

Enzyme.configure({ adapter: new Adapter() })

describe("Tweet", () => {
  let wrapper, onClickMock
  let className = ""
  let data = {
    id: 1,
    text: "This doesn't look like Kansas",
    user: {
      name: "Todo",
      profile_image_url:
        "http://images2.fanpop.com/image/quiz/400000/400752_1271413686448_431_300.jpg"
    }
  }

  beforeEach(() => {
    act(() => {
      onClickMock = jest.fn()
      wrapper = mount(
      <Tweet
        key={data.id}
        tweet={data}
        handleClick={onClickMock}
        className={className}
      />
      )
    })
  })

  it("should render an img tag with the specific props", () => {
    expect(wrapper.find("img").props()["src"]).toBe("http://images2.fanpop.com/image/quiz/400000/400752_1271413686448_431_300.jpg")
  })

  it("should render an span tag with the specific props", () => {
    expect(wrapper.find("span").text()).toBe("Todo")
  })

  it("should render an p tag with the specific props", () => {
    expect(wrapper.find("p").text()).toBe("This doesn't look like Kansas")
  })

  it('should invoke the onClick function from props when clicked', () => {
    wrapper.simulate('click');
    expect(onClickMock).toHaveBeenCalled()
  })

  it('should generate the appropriate class from props', () => {
    expect(wrapper.find("div").props()["className"]).toBe("tweet-box ")
  })
  
  it('when selected, should append "selected" to the class', () => {
    let wrapper2 = mount(
      <Tweet
        key={data.id}
        tweet={data}
        className="selected"
      />
      )
    expect(wrapper2.find("div").props()["className"]).toBe("tweet-box selected")
  })
})
