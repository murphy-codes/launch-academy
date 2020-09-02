import React from "react"
import Enzyme, { mount } from "enzyme"
import { act } from "react-dom/test-utils"
import Adapter from "enzyme-adapter-react-16"

import TwitterFeed from "./TwitterFeed"
import Tweet from "./Tweet"

Enzyme.configure({ adapter: new Adapter() })

describe("TwitterFeed", () => {
  let wrapper
  let data = [
    {
      id: 1,
      text: "This doesn't look like Kansas",
      user: {
        name: "Todo",
        profile_image_url:
          "http://images2.fanpop.com/image/quiz/400000/400752_1271413686448_431_300.jpg"
      }
    }
  ]

  beforeEach(() => {
    act(() => {
      wrapper = mount(<TwitterFeed data={data} />)
    })
  })

  it('should render a div element', () => {
    expect(wrapper.find('div')).toBeDefined();
  });

  it('should render an h1 element with the static text \n"Welcome to Dog Twitter"', () => {
    expect(wrapper.find("h1").text()).toBe("Welcome to Dog Twitter")
  });
  
  it("should initially mount the selectedTweetId set to null", () => {
    expect(wrapper.hasClass("selected")).toEqual(false)
  })

  it("should render a Tweet component", () => {
    expect(wrapper.exists(Tweet)).toEqual(true)
  })

  it("should pass down different props to the Tweet component if a corresponding Tweet component is clicked (using act()) and updated.", () => {
    const previousClassName = wrapper.find(Tweet).props().className;
    act(() => { wrapper.find(Tweet).props().handleClick() });
    wrapper.update();
    expect(wrapper.find(Tweet).props().className).not.toEqual(previousClassName);
  })
})
